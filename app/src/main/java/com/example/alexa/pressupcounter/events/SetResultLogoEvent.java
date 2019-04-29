package com.example.alexa.pressupcounter.events;

import com.example.alexa.pressupcounter.R;

/**
 * Created by Alexandr Mikhalev on 29.04.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetResultLogoEvent {

    private ResultLogo mResultLogo;

    public SetResultLogoEvent(ResultLogo resultLogo) {
        mResultLogo = resultLogo;
    }

    public ResultLogo getResultLogo() {
        return mResultLogo;
    }

    public enum ResultLogo {
        SUCCESS_LOGO(R.drawable.ic_success),
        UNSUCCESS_LOGO(R.drawable.ic_unsuccess);

        private int logoId;

        ResultLogo(int id) {
            logoId = id;
        }

        public int getLogoId() {
            return logoId;
        }
    }
}
