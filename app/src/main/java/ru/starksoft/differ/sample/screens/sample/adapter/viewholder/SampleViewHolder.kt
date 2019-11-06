package ru.starksoft.differ.sample.screens.sample.adapter.viewholder

import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_image_with_text.view.*
import ru.starksoft.differ.adapter.OnClickListener
import ru.starksoft.differ.sample.R
import ru.starksoft.differ.sample.screens.sample.adapter.SampleClickAction
import ru.starksoft.differ.sample.screens.sample.adapter.viewmodel.SampleViewModel
import ru.starksoft.differ.viewholder.DifferViewHolder

class SampleViewHolder(
	parent: ViewGroup,
	onClickListener: OnClickListener?
) : DifferViewHolder<SampleViewModel>(R.layout.item_image_with_text, parent, onClickListener) {

	override fun bind(viewModel: SampleViewModel) {
		itemView.text.text = viewModel.text

		Glide.with(itemView.context).load(viewModel.image).into(itemView.image)

		itemView.setOnClickListener {
			onClick(SampleClickAction.DELETE.ordinal)
		}

		itemView.setOnLongClickListener {
			onClick(SampleClickAction.DELETE_MULTI.ordinal)
			return@setOnLongClickListener true
		}
	}
}
