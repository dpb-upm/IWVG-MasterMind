package es.upm.miw.masterMind.controllers;

public interface PutDemoController extends ColocateController {

	Error validateTarget(String attempt);

	String getRandomAttempt();
}