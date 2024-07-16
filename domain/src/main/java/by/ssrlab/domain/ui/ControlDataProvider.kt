package by.ssrlab.domain.ui

import by.ssrlab.data.obj.ctrl.ToolbarControlObject

class ControlDataProvider {

    fun provideToolbarControlObject(
        isBack: Boolean,
        isLang: Boolean,
        isSearch: Boolean,
        isDates: Boolean
    ) = ToolbarControlObject(isBack, isLang, isSearch, isDates)
}