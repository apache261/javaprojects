
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
// Hardware.java
// Platform Tech Activity
public class Hardware{

    public static void main(String[] args) throws IOException{
        System.out.println("\n\n******* MotherBoard Info ******");
        exec("wmic BASEBOARD get product,Manufacturer /format:list");
        System.out.println("\n\n******* Processor Info ******");
        exec("wmic CPU get Name,Manufacturer, NumberOfCores,NumberOfLogicalProcessors,MaxClockSpeed,L2CacheSize,L3Cachesize /format:list");
        System.out.println("\n\n******* Memory Info ******");
        exec("wmic memorychip get capacity,speed /format:list");
        System.out.println("\n\n******* Drives Info ******");
        exec("wmic diskdrive get model,size /format:list");

  }

    // get the result of the command
    private static void exec(String command)throws IOException {
    Runtime run      = Runtime.getRuntime();
    Process proc     = run.exec(command);
    String line      = "";
    try{
        proc.waitFor();
        BufferedReader buffer = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        while((line = buffer.readLine()) != null){
            if(line.length() == 0){
                continue;
            }
            System.out.print("\n"+line);
        }
    }catch(InterruptedException e){
        e.printStackTrace();
    }

}

}