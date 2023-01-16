package Dao;

public interface implssueBook {
    /**
     * @retrun int
     * add book return 1 success
     */
    //String callno, String name, String author, String publisher, String quantity, String issued
    public int add();

    /**
     * String[][] data
     * String[] column
     * view (search) books
     */
    public void view();

    /**
     * return int
     * delete book by id
     * success return 1
     */
    public int delete(String bookcallno, int studentId);
}
