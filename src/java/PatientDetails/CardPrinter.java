/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientDetails;

/**
 *
 * @author MANUEL
 */
import java.awt.print.PrinterJob;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;

public class CardPrinter {
    public static void main(String[] args) {
        try {
            PrintService mPrinter = null;
            Boolean bFoundPrinter = false;

            PrintService[] printServices = PrinterJob.lookupPrintServices();

            //
            // Iterates the print services and print out its name.
            //
            for (PrintService printService : printServices) {
                String sPrinterName = printService.getName();
                
                
                System.out.println("current printers __"+sPrinterName);
                if (sPrinterName.equals("Send To OneNote 2010")) {
                    mPrinter = printService;
                    bFoundPrinter = true;
                }
            }

            // Open the image file 
            String testData = "Hello World !\f";
            FileInputStream is = new FileInputStream("C:\\TrueVineMedical\\TreatmentForms\\a.txt");
            //InputStream is = new ByteArrayInputStream(testData.getBytes());
            DocFlavor flavor =  DocFlavor.INPUT_STREAM.AUTOSENSE   ;

            // Find the default service
            PrintService service = PrintServiceLookup.lookupDefaultPrintService();
            System.out.println("default service is__"+service);

            // Create the print job
            DocPrintJob job = service.createPrintJob();
            Doc doc= new SimpleDoc(is, flavor, null);

            // Monitor print job events; for the implementation of PrintJobWatcher,
            PrintJobWatcher pjDone = new PrintJobWatcher(job);

            // Print it
            job.print(doc, null);

            // Wait for the print job to be done
            pjDone.waitForDone();

            // It is now safe to close the input stream
            is.close();
        } catch (PrintException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
