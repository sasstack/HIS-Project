package com.ssn.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class SsnService {
	 private static final Map<Integer, String> ssnPrefixToStateMap = new HashMap<>();

	    static {
	        // Dummy prefixes for learning/practice (not real SSN area numbers)
	        ssnPrefixToStateMap.put(10, "Alabama");
	        ssnPrefixToStateMap.put(11, "Alaska");
	        ssnPrefixToStateMap.put(12, "Arizona");
	        ssnPrefixToStateMap.put(13, "Arkansas");
	        ssnPrefixToStateMap.put(14, "California");
	        ssnPrefixToStateMap.put(15, "Colorado");
	        ssnPrefixToStateMap.put(16, "Connecticut");
	        ssnPrefixToStateMap.put(17, "Delaware");
	        ssnPrefixToStateMap.put(18, "Florida");
	        ssnPrefixToStateMap.put(19, "Georgia");

	        ssnPrefixToStateMap.put(20, "Hawaii");
	        ssnPrefixToStateMap.put(21, "Idaho");
	        ssnPrefixToStateMap.put(22, "Illinois");
	        ssnPrefixToStateMap.put(23, "Indiana");
	        ssnPrefixToStateMap.put(24, "Iowa");
	        ssnPrefixToStateMap.put(25, "Kansas");
	        ssnPrefixToStateMap.put(26, "Kentucky");
	        ssnPrefixToStateMap.put(27, "Louisiana");
	        ssnPrefixToStateMap.put(28, "Maine");
	        ssnPrefixToStateMap.put(29, "Maryland");

	        ssnPrefixToStateMap.put(30, "Massachusetts");
	        ssnPrefixToStateMap.put(31, "Michigan");
	        ssnPrefixToStateMap.put(32, "Minnesota");
	        ssnPrefixToStateMap.put(33, "Mississippi");
	        ssnPrefixToStateMap.put(34, "Missouri");
	        ssnPrefixToStateMap.put(35, "Montana");
	        ssnPrefixToStateMap.put(36, "Nebraska");
	        ssnPrefixToStateMap.put(37, "Nevada");
	        ssnPrefixToStateMap.put(38, "New Hampshire");
	        ssnPrefixToStateMap.put(39, "New Jersey");

	        ssnPrefixToStateMap.put(40, "New Mexico");
	        ssnPrefixToStateMap.put(41, "New York");
	        ssnPrefixToStateMap.put(42, "North Carolina");
	        ssnPrefixToStateMap.put(43, "North Dakota");
	        ssnPrefixToStateMap.put(44, "Ohio");
	        ssnPrefixToStateMap.put(45, "Oklahoma");
	        ssnPrefixToStateMap.put(46, "Oregon");
	        ssnPrefixToStateMap.put(47, "Pennsylvania");
	        ssnPrefixToStateMap.put(48, "Rhode Island");
	        ssnPrefixToStateMap.put(49, "South Carolina");

	        ssnPrefixToStateMap.put(50, "South Dakota");
	        ssnPrefixToStateMap.put(51, "Tennessee");
	        ssnPrefixToStateMap.put(52, "Texas");
	        ssnPrefixToStateMap.put(53, "Utah");
	        ssnPrefixToStateMap.put(54, "Vermont");
	        ssnPrefixToStateMap.put(55, "Virginia");
	        ssnPrefixToStateMap.put(56, "Washington");
	        ssnPrefixToStateMap.put(57, "West Virginia");
	        ssnPrefixToStateMap.put(58, "Wisconsin");
	        ssnPrefixToStateMap.put(59, "Wyoming");

	        ssnPrefixToStateMap.put(60, "Washington D.C.");
	    }

	    public String getStateFromSsn(String ssn) {
	        if (ssn == null || ssn.length() < 2) {
	            return "Invalid SSN";
	        }

	        try {
	            int prefix = Integer.parseInt(ssn.substring(0, 2));
	            return ssnPrefixToStateMap.getOrDefault(prefix, "Unknown State");
	        } catch (NumberFormatException e) {
	            return "Invalid SSN format";
	        }
	    }
	}
