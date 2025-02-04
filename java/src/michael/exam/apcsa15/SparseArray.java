package michael.exam.apcsa15;

import java.util.ArrayList;
import java.util.List;

public class SparseArray {
    private int numRows;
    private int numCols;
    private List<SparseArrayEntry> entries;

    public SparseArray(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        entries = new ArrayList<SparseArrayEntry>();
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    /**
     * set the value on the specified row/col entry
     * 
     * @param row
     * @param col
     * @param value
     */
    public void setValueAt(int row, int col, int value) {
        if (row > numRows || col > numCols) {
            return;
        }
        for (int i = 0; i < entries.size(); i++) {
            if (entries.get(i).getRow() == row && entries.get(i).getCol() == col) {
                entries.get(i).setValue(value);
                return;
            }
        }
        SparseArrayEntry entry = new SparseArrayEntry(row, col, value);
        this.entries.add(entry);
    }

    public int getValueAt(int row, int col) {
        for (int i = 0; i < entries.size(); i++) {
            if (entries.get(i).getRow() == row && entries.get(i).getCol() == col) {
                return entries.get(i).getValue();
            }
        }
        return 0;
    }

    public void removeColumn(int col) {
        // TODO with iterator
        for (int i = entries.size() - 1; i >= 0; i--) {
            SparseArrayEntry entry = entries.get(i);
            if (entry.getCol() == col) {
                entries.remove(i);
            } else if (entry.getCol() > col) {
                entries.set(i, new SparseArrayEntry(entry.getRow(), entry.getCol() - 1, entry.getValue()));
            }
        }
        numCols--;
    }
}
