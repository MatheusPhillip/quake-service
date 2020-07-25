package model;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GameFile {
	private ObjectInputStream input;
    private ObjectOutputStream output;
    
    public void openToWrite(String fileName){
        try{
            FileOutputStream file = new FileOutputStream(fileName);
            output = new ObjectOutputStream(file);
            System.out.println("Arquivo aberto para escrita");
        }
        catch(IOException iOException){
            System.err.println("Erro ao tentar abrir o arquivo para grava��o.");
            System.exit(1);
        }
    }
    
    public void closeAfterWrite(){
        try{
            if(output != null){
                output.close();
                output = null;
                System.out.println("Arquivo fechado com sucesso. ");
            }
        }
        catch(IOException iOException){
            System.err.println("Erro ao tentar fehar o arquivo.");
            System.exit(1);
        }
    }
    
    public void gravaObjeto(Game game){
        try{
            if(output != null){
                output.writeObject(game);               
                output.flush();
                System.out.println("Game gravado com sucesso. ");
            }
        }
        catch(IOException iOException){
            System.err.println("Erro ao tentar gravar no arquivo.");
            System.exit(1);
        }
    }
    
    
    
    
    
}
