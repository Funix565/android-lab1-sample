package lab1.progmob.getmyvariant.contract;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import lab1.progmob.getmyvariant.model.Student;

public interface AppContract {
    /**
     * Launch options screen
     * @param target fragment that launches options screen
     * @param student data about the student to be displayed
     */
    void toOptionsScreen(Fragment target,
                         @Nullable Student student);

    /**
     * Launch results screen
     * @param target fragment that launches results screen
     * @param student data used for calculating variant
     */
    void toResultsScreen(Fragment target, Student student);

    /**
     * Exit from the current screen
     */
    void cancel();

    /**
     * Publish results to the target screen
     */
    <T> void publish(T data);

    /**
     * Listen for results from other screens
     */
    <T> void registerListener(Fragment fragment, Class<T> clazz,
                              ResponseListener<T> listener);

    /**
     * Stop listening for results from other screens
     */
    void unregisterListeners(Fragment fragment);
}
