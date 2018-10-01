package es.upm.miw.masterMind.controllers;

public interface PutController extends ColocateController {

	Error validateTarget(String attempt);
}