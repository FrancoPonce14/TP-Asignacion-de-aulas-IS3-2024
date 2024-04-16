package com.TP.IS3.GRUPO3.util;

import java.awt.Color;
import java.io.IOException;
import java.util.List;
 
import javax.servlet.http.HttpServletResponse;

import com.TP.IS3.GRUPO3.domain.Usuario;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
 

public class UsuarioPDFExporter {
	private List<Usuario> lstUsuarios;
	
	public UsuarioPDFExporter(List<Usuario> lstUsuarios) {
		this.lstUsuarios = lstUsuarios;
	}
	
	private void writeTableHeader(PdfPTable table) {
		 PdfPCell cell = new PdfPCell();
	        cell.setBackgroundColor(Color.BLUE);
	        cell.setPadding(8);
	         
	        Font font = FontFactory.getFont(FontFactory.HELVETICA);
	        font.setColor(Color.WHITE);
	        
	        cell.setPhrase(new Phrase("ID", font));
	        table.addCell(cell);
	        cell.setPhrase(new Phrase("Nombre", font));
	        table.addCell(cell);
	        cell.setPhrase(new Phrase("Apellido", font));
	        table.addCell(cell); 
	        cell.setPhrase(new Phrase("Doc", font));
	        table.addCell(cell); 
	        cell.setPhrase(new Phrase("Tipo", font));
	        table.addCell(cell); 
	        cell.setPhrase(new Phrase("Email", font));
	        table.addCell(cell); 
	        cell.setPhrase(new Phrase("Perfil", font));
	        table.addCell(cell);  
	        cell.setPhrase(new Phrase("Habilitado", font));
	        table.addCell(cell);
		
	}
	private void writeTableData(PdfPTable table) {
        for (Usuario usuario : lstUsuarios) {
            table.addCell(String.valueOf(usuario.getIdUsuario()));
            table.addCell(usuario.getNombre());
            table.addCell(usuario.getApellido());
            table.addCell(Long.toString(usuario.getDocumento()));
            table.addCell(usuario.getTipoDoc());
            table.addCell(usuario.getEmail());
            table.addCell(usuario.getPerfil().getNombre());
            table.addCell(String.valueOf(usuario.isHabilitado()));
        }
		
	}
	
	public void export(HttpServletResponse response) throws DocumentException, IOException{
		Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.RED);
         
        Paragraph p = new Paragraph("Usuarios", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(8);
        table.setWidthPercentage(100f);
        table.setSpacingBefore(15);
        table.setWidths(new float[] {1.3f, 2.5f, 2.5f, 3.5f, 3.0f, 6.0f, 3.5f, 2f});
 
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
	}

}