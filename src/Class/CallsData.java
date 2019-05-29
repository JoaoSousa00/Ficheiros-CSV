package Class;

import Exceptions.AreaCodeNotFoundException;
import interfaces.CallsDataContract;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <h3>
 * ESTG - Escola Superior de Tecnologia e Gestão<br>
 * IPP - Instituto Politécnico do Porto<br>
 * LEI - Licenciatura em Engenharia Informática<br>
 * PP - Paradigmas de Programação<br>
 * </h3>
 * <p>
 * <strong>Author: </strong><br>
 * Joao Sousa<br>
 * <strong>Description: </strong><br>
 * Class that represents the mangement of the CallsData of a user
 * </p>
 */

public class CallsData implements CallsDataContract {

    @Override
    public double calculateAverageMinutesPerNumber() {
        
        double soma=0, res=0;
        int i=1;
        String[] min;
        
        String csvFile = "CallsData.csv";
        BufferedReader br = null;
        String line;
        String csvSplitBy = ";";
            
        try{
            
            System.out.println( "\n\t\t| Média dos minutos por número |\n" );
            
            br =  new BufferedReader(new FileReader(csvFile));
            line = br.readLine();
            while( ( line = br.readLine() ) != null ){
                min = line.split(csvSplitBy);
                soma = Double.parseDouble(min[1]) + Double.parseDouble(min[2]) + Double.parseDouble(min[3]);
                //System.out.println( i + " | Phone Number: " + min[6] + " Minutes: " + soma + '\n');
                i++;
                res += soma;
            }
            System.out.println( String.format( "\t Média :  %.3f minutos \n", res/i) );
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CallsData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CallsData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res/i;
    }

    @Override
    public double calculateAverageMinutesPerArea(String area_code, String outputFileName) {
        double res=-1, soma=0;
        int i=1;
        String[] min;
        
        String csvFile = "CallsData.csv";
        BufferedReader br = null;
        String line;
        String csvSplitBy = ";";
            
        try{
            
            System.out.println( "\n\t\t| Média dos minutos por área |\n" );
            
            br =  new BufferedReader(new FileReader(csvFile));
            line = br.readLine();
            
            while( ( line = br.readLine() ) != null ){
                min = line.split(csvSplitBy);
                if( area_code.equals( min[5]) ){
                    soma = Double.parseDouble(min[1]) + Double.parseDouble(min[2]) + Double.parseDouble(min[3]);
                    //System.out.println( i + " | Phone Number: " + min[6] + " Minutes: " + soma + '\n');
                    i++;
                    res += soma;
                }
            }
            if (i==1)
                throw new AreaCodeNotFoundException("|Erro: Código de área não encontrado no ficheiro");
            
            System.out.println( String.format( "\t Média :  %.3f minutos \n", res/i) ); //Uso do string.format para restringir as casas decimais apenas a duas
            
            FileOutputStream fileOut = new FileOutputStream( outputFileName + ".csv" );
            ObjectOutputStream out = new ObjectOutputStream( fileOut );
            out.writeObject( Double.toString( (res/i) ) );
            out.close();
            fileOut.close();
            System.out.println( "Informação guardada no ficheiro: " + outputFileName );
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CallsData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CallsData.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("IOException");
        } catch (AreaCodeNotFoundException ex) {
        }
        
        return res;
    }
    
}
