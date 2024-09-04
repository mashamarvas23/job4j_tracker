package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JobTest {
    @Test
    public void whenJobAscByName() {
        Comparator<Job> comparator = new JobAscByName();
        int rsl = comparator.compare(
                new Job("Ivan", 3),
                new Job("Petr", 2));
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenJobDescByName() {
        Comparator<Job> comparator = new JobDescByName();
        int rsl = comparator.compare(
                new Job("Ivan", 3),
                new Job("Petr", 2));
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenSortByPriorityJob() {
        Comparator<Job> comparator = new JobAscByPriority();
        int rsl = comparator.compare(
                new Job("Ivan", 3),
                new Job("Petr", 2));
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenSortDescByPriorityJob() {
        Comparator<Job> comparator = new JobDescByPriority();
        int rsl = comparator.compare(
                new Job("Ivan", 3),
                new Job("Petr", 2));
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByNameDescAndPriorityDesc() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Petr", 0),
                new Job("Ivan", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByNameAscAndPriorityAsc() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Ivan", 1),
                new Job("Ivan", 0)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}