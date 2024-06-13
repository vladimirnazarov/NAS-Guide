package by.ssrlab.ui.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import by.ssrlab.common_ui.databinding.RvMainItemBinding
import by.ssrlab.common_ui.common.obj.FolderObject
import by.ssrlab.ui.R
import coil.load

class FragmentMainAdapter(
    private val entitiesList: List<FolderObject>
): RecyclerView.Adapter<FragmentMainAdapter.FragmentMainViewHolder>() {

    inner class FragmentMainViewHolder(val binding: RvMainItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FragmentMainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<RvMainItemBinding>(
            inflater,
            by.ssrlab.common_ui.R.layout.rv_main_item,
            parent,
            false
        )

        return FragmentMainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FragmentMainViewHolder, position: Int) {
        holder.binding.apply {
            folderObj = entitiesList[position]
            executePendingBindings()

            rvMainPng.load(folderObj.imageResource)
        }
    }

    override fun getItemCount() = entitiesList.size
}