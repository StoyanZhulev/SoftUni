package P05_Square;

public class Rectangle {
    private int m_width;
    private int m_height;

    public Rectangle() {
    }

    public Rectangle(int m_width, int m_height) {
        this.m_width = m_width;
        this.m_height = m_height;
    }

    public void setWidth(int width) {
        m_width = width;
    }

    public void setHeight(int height) {
        m_height = height;
    }

    public int getWidth() {
        return m_width;
    }

    public int getHeight() {
        return m_height;
    }

    public int getArea() {
        return m_width * m_height;
    }
}
