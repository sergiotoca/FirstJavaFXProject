public class Seat {
    private int row;
    private int column;
    private boolean occupied;
    private Student student;
    

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        this.occupied = false;
        this.student = null;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public Student getStudent() {
        return student;
    }

    public void assignStudent(Student student) {
        this.student = student;
        this.occupied = true;
    }

    public void unassignStudent() {
        this.student = null;
        this.occupied = false;
    }
}