package com.whenling.castle.web.adminlte.tree;

import com.google.common.collect.Iterables;
import com.whenling.castle.repo.domain.Hierarchical;

public class ZTreeLazyList<T extends Hierarchical<T>> {

	private Iterable<ZTreeNode<T>> content;

	public ZTreeLazyList(Iterable<ZTreeNode<T>> content) {
		setContent(content);
	}

	public Iterable<ZTreeNode<T>> getContent() {
		return content;
	}

	protected void setContent(Iterable<ZTreeNode<T>> content) {
		this.content = content;
	}

	public static <T extends Hierarchical<T>> ZTreeLazyList<T> toZTreeLazyList(Iterable<T> datas) {
		if (datas == null) {
			return null;
		}

		Iterable<ZTreeNode<T>> content = Iterables.transform(datas, data -> new ZTreeNode<>(data));
		return new ZTreeLazyList<>(content);
	}
}
