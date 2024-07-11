package by.ssrlab.ui.rv.dates

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import by.ssrlab.common_ui.common.obj.DatesObject
import by.ssrlab.common_ui.databinding.RvDatesItemBinding
import by.ssrlab.common_ui.databinding.RvDatesTitleBinding

private const val ITEM_TITLE = 0
private const val ITEM_DATE = 1

class DatesAdapter(
    private val entitiesList: List<DatesObject>,
    private val title: String,
    private val navigateAction: (DatesObject) -> Unit
): RecyclerView.Adapter<DatesAdapter.DatesHolder>() {

    inner class DatesHolder(val binding: ViewBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DatesHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding =
            if (viewType == ITEM_TITLE) RvDatesTitleBinding.inflate(inflater, parent, false)
            else RvDatesItemBinding.inflate(inflater, parent, false)

        return DatesHolder(binding)
    }

    override fun onBindViewHolder(holder: DatesHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = entitiesList.size + 1

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) ITEM_TITLE
        else ITEM_DATE
    }
}