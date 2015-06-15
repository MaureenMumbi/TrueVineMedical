/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientDetails;

import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;

/**
 *
 * @author MANUEL
 */
public class PrinterClass {
    
    
    
     //===================THIS IS THE FUNCTION THAT PRINTS THE RECEIPTS...
    public boolean printform(String path) {

        String msg="";
        
        System.out.println("Printing FORM\n\n\n");
        
boolean retval=true;
        

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        
        
        try {
            PrintService mPrinter = null;
            Boolean bFoundPrinter = false;
         
       
   
       Date dat= new Date();
      
       String d=dat.toString().replace(" ","_");
       d=dat.toString().replace(":","_");
       
       String curreceipt =path;
//       
//     
//     

//       FileWriter outFile = new FileWriter(curreceipt ,false);
//       PrintWriter out = new PrintWriter(outFile);
//       out.print(texttoprint);
//       out.close();  
       

       
      DocFlavor flavor=null;
      
      
      
     // InputStream is = new ByteArrayInputStream(texttoprint.getBytes());
      FileInputStream is = new FileInputStream( new File(curreceipt));
      
      flavor =  DocFlavor.INPUT_STREAM.AUTOSENSE  ;   
            //look for all printers
     // PrintService[] printServices = PrinterJob.lookupPrintServices();
      
      //Here we need the default printer and not all the accessible
   PrintService service = PrintServiceLookup.lookupDefaultPrintService();
            //
            // Iterates the print services .
            //
            int a=0;
            
             //=====one can contonuosly print from here_____
                
            
                
                String sPrinterName = service.getName();
                
                
               // System.out.println("current printers __"+sPrinterName);
                 mPrinter = service;
                    bFoundPrinter = true;
                     
                DocPrintJob job = service.createPrintJob();
            Doc doc= new SimpleDoc(is, flavor, null);

            // Monitor print job events; for the implementation of PrintJobWatcher,
            PrintJobWatcher pjDone = new PrintJobWatcher(job);

            // Print it
            job.print(doc, null);

            // Wait for the print job to be done
            pjDone.waitForDone();
       
                //System.out.println("~~~~~~~This is NOT a virtual printer "+printServices[a]);    
                    
               
                
                


            // Find the default service
//            PrintService service = PrintServiceLookup.lookupDefaultPrintService();
//            System.out.println("default service is__"+service);

            
            
            //if no printer was found
            if(bFoundPrinter==false){
            retval=false;
            
             msg="<h4><font color=\"red\">NO Detected Printer. </font><h4><h5> Ensure the printer is well connected to this machine.</h5>";
        
            }
            
            
            
            // It is now safe to close the input stream
            is.close();
        } catch (PrintException e) {
            e.printStackTrace();
             msg="<h4><font color=\"red\">FORM NOT PRINTED. </font><h4><h5> Ensure the printer is well connected and that print papers are available.</h5>";
        
            
            retval=false;
        } catch (IOException e) {
            e.printStackTrace();
            
             msg="<h4><font color=\"red\">RECEIPTS NOT PRINTED. </font><h4><h5> Ensure the printer is well connected and that print papers are available.</h5>";
        
            
             retval=false;
        }
        
        
        
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        
        //==============if you print the receipt succesfully, then allow deductions to be done.
       
        return retval;
        
    }

 
    
    
    
      static class PrintJobWatcher {
        // true iff it is safe to close the print job's input stream
        boolean done = false;

        PrintJobWatcher(DocPrintJob job) {
            // Add a listener to the print job
            job.addPrintJobListener(new PrintJobAdapter() {
                public void printJobCanceled(PrintJobEvent pje) {
                    allDone();
                }
                public void printJobCompleted(PrintJobEvent pje) {
                    allDone();
                }
                public void printJobFailed(PrintJobEvent pje) {
                    allDone();
                }
                public void printJobNoMoreEvents(PrintJobEvent pje) {
                    allDone();
                }
                void allDone() {
                    synchronized (PrintJobWatcher.this) {
                        done = true;
                        PrintJobWatcher.this.notify();
                    }
                }
            });
        }
        public synchronized void waitForDone() {
            try {
                while (!done) {
                    wait();
                }
            } catch (InterruptedException e) {
            }
        }
    }
    
    
}
