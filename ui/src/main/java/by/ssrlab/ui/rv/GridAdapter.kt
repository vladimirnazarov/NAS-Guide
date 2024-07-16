package by.ssrlab.ui.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.ssrlab.data.obj.GridObject
import by.ssrlab.common_ui.databinding.RvGridItemBinding
import coil.load
import coil.transform.RoundedCornersTransformation

class GridAdapter(
    private val entitiesList: List<by.ssrlab.data.obj.GridObject>,
    private val navigateAction: () -> Unit
): RecyclerView.Adapter<GridAdapter.GridHolder>() {

    inner class GridHolder(val binding: RvGridItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RvGridItemBinding.inflate(
            inflater,
            parent,
            false
        )

        return GridHolder(binding)
    }

    override fun onBindViewHolder(holder: GridHolder, position: Int) {
        holder.binding.apply {
            gridTitle.text = entitiesList[position].title
            gridPng.load(entitiesList[position].imageSource) {
                transformations(RoundedCornersTransformation(16f))
                placeholder(by.ssrlab.common_ui.R.drawable.coil_placeholder)
                crossfade(500)
                crossfade(true)
            }
            gridRipple.setOnClickListener {
                navigateAction()
            }
        }
    }

    override fun getItemCount() = entitiesList.size
}