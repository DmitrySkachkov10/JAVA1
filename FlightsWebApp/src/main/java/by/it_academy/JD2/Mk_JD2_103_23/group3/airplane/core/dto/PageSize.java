package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.dto;

import java.util.Objects;

public class PageSize {
    private int page;

    private int size;

    public PageSize() {
    }

    public PageSize(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PageSize)) return false;
        PageSize pageSize = (PageSize) o;
        return page == pageSize.page && size == pageSize.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(page, size);
    }

    @Override
    public String toString() {
        return "PageSize{" +
                "page=" + page +
                ", size=" + size +
                '}';
    }
}
