package yams.model;

public interface TableCell extends Cell {

    public TableCellState getState();

    public void setState(TableCellState state);

    public Mine mine();

    public boolean hasMine();
}
