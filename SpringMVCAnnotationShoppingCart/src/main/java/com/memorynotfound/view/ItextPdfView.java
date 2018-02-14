package com.memorynotfound.view;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import org.o7planning.springmvcshoppingcart.model.CartInfo;
import org.o7planning.springmvcshoppingcart.model.CartLineInfo;
import org.o7planning.springmvcshoppingcart.model.OrderInfo;
import org.o7planning.springmvcshoppingcart.util.Utils;

public class ItextPdfView extends AbstractITextPdfView {

    private static final DateFormat DATE_FORMAT = DateFormat.getDateInstance(DateFormat.SHORT);

    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document, PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        @SuppressWarnings("unchecked")
        CartInfo cartInfo2 = Utils.getCartInSession(request);
        
        PdfPTable table1 = new PdfPTable(1);
        table1.setWidths(new int[]{100});

        table1.addCell("Datos del Comprador");
        
        PdfPTable table = new PdfPTable(6);
        table.setWidths(new int[]{10, 10,20, 20,20,20});

  
    
        table.addCell("Número pedido");
        table.addCell("Precio");
        table.addCell("Nombre");
        table.addCell("Direccion");
        table.addCell("Email");
        table.addCell("Telefono");

        

        
            table.addCell(String.valueOf(cartInfo2.getQuantityTotal()));
            table.addCell(String.valueOf(cartInfo2.getAmountTotal()));
            table.addCell(cartInfo2.getCustomerInfo().getName());
            table.addCell(cartInfo2.getCustomerInfo().getAddress());
            table.addCell(cartInfo2.getCustomerInfo().getEmail());
            table.addCell(cartInfo2.getCustomerInfo().getPhone());
           
            PdfPTable table2 = new PdfPTable(4);
            table2.setWidths(new int[]{20, 20,20,20});

      
        
            table2.addCell("Cantidad");
            table2.addCell("Código");
            table2.addCell("Nombre");
            table2.addCell("Precio");
     
for (CartLineInfo cartinfos: cartInfo2.getCartLines()) {
	

            

            
                table2.addCell(String.valueOf(cartinfos.getQuantity()));
                table2.addCell(String.valueOf(cartinfos.getProductInfo().getCode()));
                table2.addCell(String.valueOf(cartinfos.getProductInfo().getName()));
                table2.addCell(String.valueOf(cartinfos.getAmount()));
}
document.add(table1);

        document.add(table);
        document.add(table2);
    }
}

