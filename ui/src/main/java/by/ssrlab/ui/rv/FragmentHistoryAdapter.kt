package by.ssrlab.ui.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import by.ssrlab.common_ui.common.obj.FolderObject
import by.ssrlab.common_ui.databinding.RvFolderItemBinding

class FragmentHistoryAdapter(
    private val entitiesList: List<FolderObject>,
    private val pngLoadAction: (ImageView, Int) -> Unit,
    private val navigateAction: (Int) -> Unit
): RecyclerView.Adapter<FragmentHistoryAdapter.FragmentHistoryHolder>() {

    inner class FragmentHistoryHolder(val binding: RvFolderItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FragmentHistoryHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<RvFolderItemBinding>(
            inflater,
            by.ssrlab.common_ui.R.layout.rv_folder_item,
            parent,
            false
        )

        return FragmentHistoryHolder(binding)
    }

    override fun onBindViewHolder(holder: FragmentHistoryHolder, position: Int) {
        holder.binding.apply {
            folderObj = entitiesList[position]
            executePendingBindings()

            pngLoadAction(rvFolderMainPng, entitiesList[position].imageResource)
            rvFolderMainRipple.setOnClickListener {
                navigateAction(entitiesList[position].address)
            }
        }
    }

    override fun getItemCount() = entitiesList.size
}