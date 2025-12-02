package excepcions;

public class FileNotFoundException extends Exception {
    private String filePath;

    // Constructor que acepta un mensaje y ruta del archivo
    public FileNotFoundException(String message, String filePath) {
        super(message);
        this.filePath = filePath;
    }

    // Método para obtener la ruta del archivo
    public String getFilePath() {
        return filePath;
    }
}
