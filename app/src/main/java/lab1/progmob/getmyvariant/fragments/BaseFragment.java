package lab1.progmob.getmyvariant.fragments;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import lab1.progmob.getmyvariant.contract.AppContract;
import lab1.progmob.getmyvariant.contract.ResponseListener;

public class BaseFragment extends Fragment {
    private AppContract appContract;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.appContract = (AppContract) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.appContract.unregisterListeners(this);
        this.appContract = null;
    }

    final AppContract getAppContract() {
        return appContract;
    }

    final <T> void registerListener(Class<T> clazz, ResponseListener<T> listener) {
        getAppContract().registerListener(this, clazz, listener);
    }
}
