package by.ssrlab.ui.rv

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.ssrlab.common_ui.common.obj.FolderObject
import by.ssrlab.common_ui.databinding.RvSectionItemBinding

class FragmentInventionsAdapter(
    private val entitiesList: List<FolderObject>
): RecyclerView.Adapter<FragmentInventionsAdapter.FragmentInventionsHolder>() {

    inner class FragmentInventionsHolder(val binding: RvSectionItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FragmentInventionsHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: FragmentInventionsHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = entitiesList.size
}