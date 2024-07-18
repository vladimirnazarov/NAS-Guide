package by.ssrlab.ui.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import by.ssrlab.common_ui.databinding.RvDatesItemBinding
import by.ssrlab.common_ui.databinding.RvDatesTitleBinding
import by.ssrlab.data.obj.DateObject
import coil.load
import coil.transform.RoundedCornersTransformation

private const val ITEM_TITLE = 0
private const val ITEM_DATE = 1

class DatesAdapter(
    private val entitiesList: List<DateObject>,
    private val title: String,
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
        holder.binding.apply {
            when (this@apply) {
                is RvDatesTitleBinding -> {
                    this.rvDatesTitle.text = title
                }

                is RvDatesItemBinding -> {
                    this.rvDatesDate.text = entitiesList[position].date
                    this.rvDatesBody.text = entitiesList[position].body

                    this.rvDatesPng.load(entitiesList[position]) {
                        crossfade(true)
                        crossfade(500)
                        placeholder(by.ssrlab.common_ui.R.drawable.coil_placeholder)
                        transformations(RoundedCornersTransformation(8f))
                    }

                    this.rvDatesRipple.setOnClickListener {
                        //TODO
                    }
                }
            }
        }
    }

    override fun getItemCount() = entitiesList.size + 1

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) ITEM_TITLE
        else ITEM_DATE
    }
}