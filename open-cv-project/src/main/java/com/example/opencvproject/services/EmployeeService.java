package com.example.opencvproject.services;

import com.example.opencvproject.entities.EmployeeEntity;
import com.example.opencvproject.models.EmployeeModel;
import com.example.opencvproject.repositories.EmployeeRepository;
import nu.pattern.OpenCV;
import org.opencv.core.*;
import org.opencv.features2d.DescriptorMatcher;
import org.opencv.features2d.ORB;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeModel getEmployeeDetailsByProfilePhoto(String imagePath) {
        OpenCV.loadShared();
        Mat sourceImageMatFormat = Imgcodecs.imread(imagePath);
        AtomicReference<Double> bestMatcher = new AtomicReference<>(Double.MAX_VALUE);
        AtomicReference<Long> employeeId = new AtomicReference<>();
        MatOfKeyPoint matOfKeyPoint = new MatOfKeyPoint();
        Mat sourceDescriptor = new Mat();
        ORB orb = ORB.create();
        orb.detectAndCompute(sourceImageMatFormat, new Mat(), matOfKeyPoint, sourceDescriptor);

        employeeRepository.findAll().forEach(data->{
           Mat storedImageMatFormat = Imgcodecs.imread(data.getProfilePhoto());
            MatOfKeyPoint matOfKeyPoint1 = new MatOfKeyPoint();
            Mat storedDescriptor = new Mat();
            orb.detectAndCompute(storedImageMatFormat, new Mat(), matOfKeyPoint1, storedDescriptor);
            DescriptorMatcher descriptorMatcher = DescriptorMatcher.create(DescriptorMatcher.BRUTEFORCE_HAMMING);
            MatOfDMatch matOfDMatch = new MatOfDMatch();
            descriptorMatcher.match(sourceDescriptor, storedDescriptor, matOfDMatch);

            List<DMatch> dMatches = matOfDMatch.toList();
            double matchscore = dMatches.stream().mapToDouble(match-> match.distance).average().orElse(Double.MAX_VALUE);
            System.out.println("bestMatcher.get()=====>"+bestMatcher.get());

            if(matchscore < bestMatcher.get()){
                bestMatcher.set(matchscore);
                employeeId.set(data.getId());
            }
        });
        EmployeeEntity employeeEntity = employeeRepository.findById(Long.parseLong(String.valueOf(employeeId))).get();
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setId(employeeEntity.getId());
        employeeModel.setEmployeeName(employeeEntity.getEmployeeName());
        employeeModel.setEmployeeMobile(employeeEntity.getEmployeeMobile());
        employeeModel.setEmployeeEmail(employeeEntity.getEmployeeEmail());
        employeeModel.setProfilePhoto(employeeEntity.getProfilePhoto());
        return employeeModel;

    }

}
