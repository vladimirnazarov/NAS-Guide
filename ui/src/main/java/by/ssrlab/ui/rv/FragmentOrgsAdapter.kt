package by.ssrlab.ui.rv

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.ssrlab.common_ui.common.obj.FolderObject
import by.ssrlab.common_ui.databinding.RvSectionItemBinding

class FragmentOrgsAdapter(
    private val entitiesList: List<FolderObject>
): RecyclerView.Adapter<FragmentOrgsAdapter.FragmentOrgsHolder>() {

    inner class FragmentOrgsHolder(val binding: RvSectionItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FragmentOrgsHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: FragmentOrgsHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = entitiesList.size
}