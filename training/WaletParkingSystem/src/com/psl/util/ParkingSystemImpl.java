package com.psl.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.psl.bean.ParkingBlock;
import com.psl.exception.ParkingFullException;

public class ParkingSystemImpl implements ParkingSystem {

	@Override
	public Set<ParkingBlock> populateData(String fileName) {

		Set<ParkingBlock> returnSet = new TreeSet<ParkingBlock>(
				new Comparator<ParkingBlock>() {

					@Override
					public int compare(ParkingBlock p1, ParkingBlock p2) {

						return p1.getBlockNumber() - p2.getBlockNumber();
					}
				});

		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(fileName));
			while (scanner.hasNext()) {

				String[] temp = scanner.nextLine().split(",");
				if (temp.length == 3) {
					int blockNumber = Integer.parseInt(temp[0].trim());
					int vehicleNumber = Integer.parseInt(temp[1].trim());
					int parkTime = Integer.parseInt(temp[2].trim());
					returnSet.add(new ParkingBlock(blockNumber, vehicleNumber,
							parkTime, 0, 0));
				} else {
					int blockNumber = Integer.parseInt(temp[0].trim());
					returnSet.add(new ParkingBlock(blockNumber, 2000, 0, 0, 0));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return returnSet;
	}

	@Override
	public ParkingBlock removeVehicle(Set<ParkingBlock> treeSet,
			int vehicleNum, int outitme) {

		int blockNumber = 0;
		int vehicleNumber = 0;
		int parkTime = 0;
		int outTime = 0;
		double charge = 0.0;

		for (ParkingBlock parkingBlock : treeSet) {
			
			if (parkingBlock.getVehicleNumber() == vehicleNum) {
			
				parkingBlock.setOutTime(outitme);
				int totalTime = (int)((outitme - parkingBlock.getParkTime())/100);
				parkingBlock.setCharge(totalTime * 10);

				blockNumber = parkingBlock.getBlockNumber();
				vehicleNumber = parkingBlock.getVehicleNumber();
				parkTime = parkingBlock.getParkTime();
				outTime = parkingBlock.getOutTime();
				charge = parkingBlock.getCharge();

				parkingBlock.setVehicleNumber(2000);
				parkingBlock.setOutTime(0);
				parkingBlock.setParkTime(0);
				parkingBlock.setCharge(0);
				
				
				
			}
		}
		return new ParkingBlock(blockNumber, vehicleNumber, parkTime, outTime,
				charge);
	}

	@Override
	public Set<ParkingBlock> sortByParkingTime(Set<ParkingBlock> treeSet) {

		Set<ParkingBlock> set = new TreeSet<ParkingBlock>(
				new Comparator<ParkingBlock>() {
					@Override
					public int compare(ParkingBlock p1, ParkingBlock p2) {
						if (p1.getParkTime() == p2.getParkTime()) {
							return p1.getBlockNumber() - p2.getBlockNumber();
						}
						return p1.getParkTime() - p2.getParkTime();
					}
				});
		set.addAll(treeSet);
		return set;
	}

	@Override
	public void parkVehicle(Set<ParkingBlock> set, int vehicleNumber,
			int parkTime) throws ParkingFullException {

		boolean flag = true;
		for (ParkingBlock parkingBlock : set) {
			if (parkingBlock.getVehicleNumber() == 2000
					&& parkingBlock.getParkTime() == 0) {
				flag = false;
				parkingBlock.setVehicleNumber(vehicleNumber);
				parkingBlock.setParkTime(parkTime);
				return;
			}
		}
		if (flag) {
			throw new ParkingFullException();
		}

	}

}
