package it.meucci;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class main 
{
    public static void main( String[] args )
    {

        //questo è il percorso file da deserializzare
        File file = new File("src/main/java/it/meucci/classe.xml");
        
        XmlMapper xmlMapper = new XmlMapper();

        root value = xmlMapper.readValue(file, root.class);
        
        //viene stampato a schermo i dati all'interno del file xml
        System.out.println("La Classe " + value.getClasse() + " " + value.getSpecializzazione() + " si trova nell'Aula " + value.getAula().getNome() + " ed è composta dai seguenti Studenti:"); 
        
        //ciclo for per stampare a schermo tutti gli studenti dentro il vettore
        for(int i = 0; i < value.getStudenti().size(); i++){

            System.out.println("- " + value.getStudenti().get(i).getCognome() + " " + value.getStudenti().get(i).getNome());

        }

        //Serializzazione FILE
        //stampo a schermo le stringhe
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT); 

        //viene serializzato
        xmlMapper.writeValue(new File("src/main/java/it/meucci/classeAgg.xml"), value); 

        //viene creato nuovo file xml
        File newFile = new File("classeAgg.xml"); 
        
        //viene fatta la serializzazione Stringa
        String xml = xmlMapper.writeValueAsString(value);

        System.out.println("\n" + xml);
    }
}






