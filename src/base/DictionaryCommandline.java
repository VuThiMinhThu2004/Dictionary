public class DictionaryCommandline extends Dictionary {

    /*năng hiển thị kết quả danh sách dữ liệu từ vựng trên màn
    hình theo thứ tự alphabet. Ví dụ như sau:
    No | English | Vietnamese
    1 | Hello | Xin chao
     */

    public static void showAllWords() {
        System.out.printf("No", '|' ,"English", '|', "Vietnamese");
        for (int i = 0; i < listVocab.size(); i++) {
            System.out.printf( i + 1,'|', listVocab.get(i).getSearching(), '|',listVocab.get(i).getMeaning());
        }
    }


    /*Xây dựng giao diện menu dòng lệnh của ứng dụng như ví dụ sau:
    Welcome to My Application!
    [0] Exit
    [1] Add
     */
    public void dictionaryBasic() {
        DictionaryManagement.insertFromCommandline();
        showAllWords();
    }
}