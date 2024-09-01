package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double averageScore = 0;
        for (Pupil pupil : pupils) {
            double averageScorePupil = 0;
            for (Subject subject : pupil.subjects()) {
                averageScorePupil += subject.score();
            }
            averageScore += (averageScorePupil / pupil.subjects().size());
        }
        return averageScore / pupils.size();
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double averageScorePupil = 0;
            for (Subject subject : pupil.subjects()) {
                averageScorePupil += subject.score();
            }

            Label label = new Label(pupil.name(), averageScorePupil / pupil.subjects().size());
            labels.add(label);
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> tmpMap = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                tmpMap.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        List<Label> labelList = new ArrayList<>();
        for (String key : tmpMap.keySet()) {
            labelList.add(new Label(key, (double) tmpMap.get(key) / pupils.size()));
        }
        return labelList;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double averageScorePupil = 0;
            for (Subject subject : pupil.subjects()) {
                averageScorePupil += subject.score();
            }
            Label label = new Label(pupil.name(), averageScorePupil);
            labels.add(label);
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> tmpMap = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                tmpMap.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        List<Label> labelList = new ArrayList<>();
        for (String key : tmpMap.keySet()) {
            labelList.add(new Label(key, tmpMap.get(key)));
        }
        labelList.sort(Comparator.naturalOrder());
        return labelList.get(labelList.size() - 1);
    }
}





