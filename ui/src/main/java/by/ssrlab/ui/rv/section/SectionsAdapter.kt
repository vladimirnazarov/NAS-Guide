package by.ssrlab.ui.rv.section

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.ssrlab.common_ui.common.obj.SectionObject
import by.ssrlab.common_ui.databinding.RvSectionItemBinding
import coil.load
import coil.transform.RoundedCornersTransformation

class SectionsAdapter(
    private val entitiesList: List<SectionObject>,
    private val navigateAction: (Int) -> Unit
): RecyclerView.Adapter<SectionsAdapter.SectionHolder>() {

    inner class SectionHolder(val binding: RvSectionItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RvSectionItemBinding.inflate(
            inflater,
            parent,
            false
        )

        return SectionHolder(binding)
    }

    override fun onBindViewHolder(holder: SectionHolder, position: Int) {
        holder.binding.apply {
            val positionStr = "$position."
            rvSectionNumber.text = positionStr
            rvSectionTitle.text = entitiesList[position].title
            rvSectionPng.load(entitiesList[position].imageSource) {
                transformations(RoundedCornersTransformation(16f))
                placeholder(by.ssrlab.common_ui.R.drawable.coil_placeholder_animated)
                crossfade(500)
            }
            rvSectionRipple.setOnClickListener {
                navigateAction(entitiesList[position].address)
            }
        }
    }

    override fun getItemCount() = entitiesList.size
}