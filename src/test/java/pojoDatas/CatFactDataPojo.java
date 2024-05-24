package pojoDatas;

public class CatFactDataPojo {

    private  int statusCode = 200;
    private  String contentType = "application/json";
    private int length = 30;

    private int limite = 2;

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
