package pojoDatas;

public class CatFactDataPojo {

    private  int statusCode;
    private  String contentType;
    private int length;

    private int limite;

    public CatFactDataPojo(int statusCode, String contentType, int length, int limite) {
        this.statusCode = statusCode;
        this.contentType = contentType;
        this.length = length;
        this.limite = limite;
    }   public CatFactDataPojo(int statusCode, String contentType, int length) {
        this.statusCode = statusCode;
        this.contentType = contentType;
        this.length = length;
    }   public CatFactDataPojo(int statusCode, String contentType) {
        this.statusCode = statusCode;
        this.contentType = contentType;
    }


    public CatFactDataPojo() {
    }


    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }


    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "CatFactDataPojo{" +
                "statusCode=" + statusCode +
                ", contentType='" + contentType + '\'' +
                ", length=" + length +
                ", limite=" + limite +
                '}';
    }
}
