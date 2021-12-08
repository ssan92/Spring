package ec.com.ioet.ACME.service.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.springframework.stereotype.Component;

import ec.com.ioet.ACME.constantes.AcmeConstante;
import ec.com.ioet.ACME.repository.entity.Reporte;

@Component
public class CrearArchivo {

	
	public File crearArchivoTXT(Iterable<Reporte> reportes,String ruta) {
		FileWriter fw =null;
		File file=null;
		try {
            
            file = File.createTempFile(ruta, null);
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("PARES Y FRECUENCIA | PARAMETRO FECHA INICIO | PARAMETRO FECHA FIN | FECHA GENERACION"+"\n");
            for (Iterator iterator = reportes.iterator(); iterator.hasNext();) {
    			Reporte rpt = (Reporte) iterator.next();
    			String fInicio=ApiUtil.format(rpt.getFechaInicioParam(),AcmeConstante.YYYYMMDD);
    			String fFin=ApiUtil.format(rpt.getFechaFinParam(),AcmeConstante.YYYYMMDD);
    			String fIngreso=ApiUtil.format(rpt.getFechaGeneracion(),AcmeConstante.YYYYMMDDHH24MISS);
            	bw.write(rpt.getPares()+":"+rpt.getFrecuencia()+" | "+fInicio+" | "+fFin+" | "+fIngreso+"\n");
			}
            
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return file;
	}
}
