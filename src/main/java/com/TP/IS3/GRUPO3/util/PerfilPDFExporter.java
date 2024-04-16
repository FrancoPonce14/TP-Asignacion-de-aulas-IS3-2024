package com.TP.IS3.GRUPO3.util;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.TP.IS3.GRUPO3.domain.Perfil;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PerfilPDFExporter {
	private List<Perfil> lstPerfiles;
	
	public PerfilPDFExporter(List<Perfil> lstPerfiles){
		this.lstPerfiles = lstPerfiles;
	}
	
	private void writeTableHeader(PdfPTable table) {
		 PdfPCell cell = new PdfPCell();
	        cell.setBackgroundColor(Color.BLUE);
	        cell.setPadding(3);
	         
	        Font font = FontFactory.getFont(FontFactory.HELVETICA);
	        font.setColor(Color.WHITE);
	        
	        cell.setPhrase(new Phrase("ID", font));
	        table.addCell(cell);
	        cell.setPhrase(new Phrase("Nombre", font));
	        table.addCell(cell);
	        cell.setPhrase(new Phrase("Habilitado", font));
	        table.addCell(cell); 
		
	}
	private void writeTableData(PdfPTable table) {
       for (Perfil perfil : lstPerfiles) {
           table.addCell(String.valueOf(perfil.getIdPerfil()));
           table.addCell(perfil.getNombre());
           table.addCell(String.valueOf(perfil.isHabilitado()));
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
        
       PdfPTable table = new PdfPTable(3);
       table.setWidthPercentage(100f);
       table.setSpacingBefore(15);
       table.setWidths(new float[] {1.5f, 4f, 2.5f});

        
       writeTableHeader(table);
       writeTableData(table);
        
       document.add(table);
        
       document.close();
	}

}