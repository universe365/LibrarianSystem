package Dao;

public interface implLibrarian {
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
     * @return int
     * update info
     */
    public int update();

    /**
     * return int
     * delete book by id
     * success return 1
     */
    public int delete(int id);

    /**
     * return true while username(name) and password are exist
     * 使用 select from 語句撈出該使用者 如有符合 回傳true 在LibrarianLogin.java中執行
     */
    public boolean verify(String name, String password);
}
