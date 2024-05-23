package pojoDatas;

public class CatFactDataPojo {
    /*
    {
  "fact": "The richest cat is Blackie who was left £15 million by his owner, Ben Rea.",
  "length": 74
}
     */


    private int length =30;

    private int limite =2;

    public CatFactDataPojo() {
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
                ", length=" + length +
                ", limite=" + limite +
                '}';
    }
}
