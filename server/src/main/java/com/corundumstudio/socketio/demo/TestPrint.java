package com.corundumstudio.socketio.demo;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;

public class TestPrint {
    public static void print(String args) {
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
        System.out.println("Number of print services: " + printServices.length);

        System.out.println("Available printer: ");
        PrintService mPrintService = null;        
        PrintService defaultPrinter = PrintServiceLookup.lookupDefaultPrintService();
        for (PrintService printer : printServices) {
            System.out.println(printer.getName());
            if("Microsoft Print to PDF".equals(printer.getName())) {
            	defaultPrinter = printer;
            }
        }

        if (defaultPrinter != null) {
            System.out.println("Default printer: " + defaultPrinter.getName()); 
//            defaultPrinter.
            System.out.println("Default printer: " + defaultPrinter);
            DocPrintJob docPrintJob= defaultPrinter.createPrintJob();
            DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
            Doc doc = new SimpleDoc(args.getBytes(), flavor, null);
            try {
docPrintJob.print(doc, null);
//	docPrintJob.
} catch (PrintException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
        }
    }   
}