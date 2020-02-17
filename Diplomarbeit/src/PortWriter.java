import java.io.OutputStream;
import java.util.Enumeration;

import javax.comm.*;

public class PortWriter
{
    static Enumeration ports;
    static CommPortIdentifier pID;
    static OutputStream outStream;
    SerialPort serPort;
    
    public PortWriter() {}
    public void portWriterInit() throws Exception{
        serPort = (SerialPort)pID.open("PortWriter",2000);
        outStream = serPort.getOutputStream();
        serPort.setSerialPortParams(9600, SerialPort.DATABITS_8,
        SerialPort.STOPBITS_1,
        SerialPort.PARITY_NONE);
    }    
    
    public static void write() throws Exception{
        ports = CommPortIdentifier.getPortIdentifiers();
        System.out.println(CommPortIdentifier.getPortIdentifier("COM4"));
        while(ports.hasMoreElements())
        {
            pID = (CommPortIdentifier)ports.nextElement();
            System.out.println("Port " + pID.getName());
            
            if (pID.getPortType() == CommPortIdentifier.PORT_SERIAL)
            {
                if (pID.getName().equals(GUI.jcom.getSelectedItem().toString()))
                {
                    PortWriter pWriter = new PortWriter();
                    pWriter.portWriterInit();
                    System.out.println(GUI.jcom.getSelectedItem().toString()+" found");
                    
                }
            }
        }
        outStream.write(GUI.objectheight);
        outStream.write(GUI.mode);
        outStream.write(GUI.center);
    }
}
