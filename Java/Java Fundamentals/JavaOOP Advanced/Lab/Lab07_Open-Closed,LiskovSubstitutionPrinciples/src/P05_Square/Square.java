package P05_Square;

public class Square extends Rectangle {


    public Square(int m_width, int m_height) {
        this.validate(m_width, m_height);
        super.setHeight(m_height);
        super.setWidth(m_width);
    }

    public Square(int side){
        super(side, side);
    }

    private void validate(int width, int height){
        if(width != height){
            throw new IllegalArgumentException("Not a square");
        }
    }
}
