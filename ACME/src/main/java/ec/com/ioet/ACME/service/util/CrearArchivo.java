package ec.com.ioet.ACME.service.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import ec.com.ioet.ACME.constantes.AcmeConstante;
import ec.com.ioet.ACME.repository.entity.Reporte;

@Component
public class CrearArchivo {

	
	public File crearArchivoTXT(Iterable<Reporte> reportes,String ruta) {
		FileWriter fw =null;
		File file=null;
		try {
            
            file = File.createTempFile(ruta, null);//new File(ruta);
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            SimpleDateFormat format=new SimpleDateFormat(AcmeConstante.YYYYMMDD);
            bw.write("PARES Y FRECUENCIA | PARAMETRO FECHA INICIO | PARAMETRO FECHA FIN | FECHA GENERACION"+"\n");
            for (Iterator iterator = reportes.iterator(); iterator.hasNext();) {
    			Reporte rpt = (Reporte) iterator.next();
    			String fInicio=format.format(rpt.getFechaInicioParam());
    			String fFin=format.format(rpt.getFechaFinParam());
    			String fIngreso=format.format(rpt.getFechaGeneracion());
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
