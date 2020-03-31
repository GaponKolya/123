package text;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Загружаем изображение (указываем путь)
        Image image = new Image("https://pp.userapi.com/c847019/v847019671/15ae22/I5YNiAPpLXA.jpg?ava=1");
        // Загруженное изображение отображаем в контейнере.
        ImageView imageView = new ImageView(image);

        // Контейнеру прописываем расположение в контейнере верхнего уровня
        imageView.setLayoutX(0);
        imageView.setLayoutY(0);

        // Контейнером верхнего уровня будет Группа. Она же будет корнем сцены приложения.
        Group root = new Group();
        // Добавляем дочерний элемент к корню - наш контейнер отображения картинки.
        root.getChildren().add(imageView);

        // Создаём сцену. (корень, ширина окна, высота окна)
        Scene scene = new Scene(root, 300, 250);

        // Имя приложения в шапке окна.
        primaryStage.setTitle("Картинка");
        // Назначаем сцену приложению.
        primaryStage.setScene(scene);
        // Отображаем сцену.
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}