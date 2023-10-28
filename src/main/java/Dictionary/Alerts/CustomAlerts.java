package Dictionary.Alerts;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ButtonBar.ButtonData;

public class CustomAlerts {

    /*
    thông báo thông tin và cảnh báo cho người dùng.
     */
    private Alert showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);

        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(content);

        return alert;
    }

    public void showInfoAlert(String title, String content) {
        showAlert(Alert.AlertType.INFORMATION, title, content);
    }

    public void showWarningAlert(String title, String content) {
        showAlert(Alert.AlertType.WARNING, title, content);
    }

    /*
    Tạo một thông báo xác nhận và một thông báo cảnh báo.
     */
    public Alert createConfirmationAlert(String title, String content) {
        return showAlert(Alert.AlertType.CONFIRMATION, title, content);
    }

    public Alert createWarningAlert(String title, String content) {//Tạo một thông báo xác nhận.
        return showAlert(Alert.AlertType.WARNING, title, content);
    }


    // Phương thức để thêm các nút tùy chọn cho các thông báo xác nhận
    public void addConfirmationButtons(Alert alert, String confirmButtonText, String cancelButtonText) {
        ButtonType confirmButton = new ButtonType(confirmButtonText, ButtonData.OK_DONE);
        ButtonType cancelButton = new ButtonType(cancelButtonText, ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(confirmButton, cancelButton);// Đối tượng Alert cần thêm nút.
    }
}
