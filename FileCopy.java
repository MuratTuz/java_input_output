package inputOutput;

import java.io.*;
import java.util.*;

public class FileCopy {
    public static void main(String[] args) throws IOException {

        //byteStreamFileCopy();
        characterStreamFileReadWrite();
    }

    public static void characterStreamFileReadWrite() throws IOException {
        Map<Integer, String> filemap = new TreeMap<>();
        StringBuilder fileLine = new StringBuilder();
        boolean lineFlag = false;

        Reader fileReader = new FileReader("src/inputOutput/story-input.txt");
        int lineCharacter = fileReader.read();
        while (lineCharacter >= 0){
            if ((char)lineCharacter == '\r') {
                createLine(fileLine, filemap);
                lineFlag = true;
            }
            if (lineFlag) {
                lineFlag = false;
                fileReader.read(); // \n character
            } else{
                fileLine.append((char)lineCharacter);
            }
            lineCharacter = fileReader.read();
        }

        FileWriter fileWriter = new FileWriter("src/inputOutput/story-input2.txt");
        for (Integer key : filemap.keySet()){
            fileWriter.write(filemap.get(key));
        }
        fileWriter.close();

    }

    private static void createLine(StringBuilder fileLine, Map<Integer, String> filemap) {
        filemap.put(Integer.valueOf(fileLine.substring(0,3)), fileLine.substring(4,fileLine.length())+" ");
        fileLine.delete(0,fileLine.length());
    }


    public static void byteStreamFileCopy() throws IOException {
        String file="";

        BufferedReader fileLocation = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please enter the file name including the location : ");
        file = String.valueOf(fileLocation.readLine());
        InputStream inputStream = new FileInputStream(file);

        int fileContent = inputStream.read();
        List<Byte> fileBytes = new LinkedList<>();
        while (fileContent >= 0){
            fileBytes.add((byte)fileContent);
            fileContent = inputStream.read();
        }
        inputStream.close();

        String newfile = file.substring(0,file.length()-4)+"2"+file.substring(file.length()-4);
        OutputStream outputStream = new FileOutputStream(newfile,false);
        int fileBytesSize = fileBytes.size();
        byte[] filewrites = new byte[fileBytesSize];
        for (int i = 0; i < fileBytesSize; i++) {
            filewrites[i] = fileBytes.get(i);
        }


        outputStream.write(filewrites);
        outputStream.close();
    }
}
