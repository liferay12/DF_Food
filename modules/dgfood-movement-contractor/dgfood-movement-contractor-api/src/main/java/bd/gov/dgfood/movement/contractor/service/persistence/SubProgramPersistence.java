/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package bd.gov.dgfood.movement.contractor.service.persistence;

import bd.gov.dgfood.movement.contractor.exception.NoSuchSubProgramException;
import bd.gov.dgfood.movement.contractor.model.SubProgram;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the sub program service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubProgramUtil
 * @generated
 */
@ProviderType
public interface SubProgramPersistence extends BasePersistence<SubProgram> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SubProgramUtil} to access the sub program persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the sub program in the entity cache if it is enabled.
	 *
	 * @param subProgram the sub program
	 */
	public void cacheResult(SubProgram subProgram);

	/**
	 * Caches the sub programs in the entity cache if it is enabled.
	 *
	 * @param subPrograms the sub programs
	 */
	public void cacheResult(java.util.List<SubProgram> subPrograms);

	/**
	 * Creates a new sub program with the primary key. Does not add the sub program to the database.
	 *
	 * @param subProgramId the primary key for the new sub program
	 * @return the new sub program
	 */
	public SubProgram create(long subProgramId);

	/**
	 * Removes the sub program with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param subProgramId the primary key of the sub program
	 * @return the sub program that was removed
	 * @throws NoSuchSubProgramException if a sub program with the primary key could not be found
	 */
	public SubProgram remove(long subProgramId)
		throws NoSuchSubProgramException;

	public SubProgram updateImpl(SubProgram subProgram);

	/**
	 * Returns the sub program with the primary key or throws a <code>NoSuchSubProgramException</code> if it could not be found.
	 *
	 * @param subProgramId the primary key of the sub program
	 * @return the sub program
	 * @throws NoSuchSubProgramException if a sub program with the primary key could not be found
	 */
	public SubProgram findByPrimaryKey(long subProgramId)
		throws NoSuchSubProgramException;

	/**
	 * Returns the sub program with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param subProgramId the primary key of the sub program
	 * @return the sub program, or <code>null</code> if a sub program with the primary key could not be found
	 */
	public SubProgram fetchByPrimaryKey(long subProgramId);

	/**
	 * Returns all the sub programs.
	 *
	 * @return the sub programs
	 */
	public java.util.List<SubProgram> findAll();

	/**
	 * Returns a range of all the sub programs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubProgramModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sub programs
	 * @param end the upper bound of the range of sub programs (not inclusive)
	 * @return the range of sub programs
	 */
	public java.util.List<SubProgram> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the sub programs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubProgramModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sub programs
	 * @param end the upper bound of the range of sub programs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sub programs
	 */
	public java.util.List<SubProgram> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SubProgram>
			orderByComparator);

	/**
	 * Returns an ordered range of all the sub programs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubProgramModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sub programs
	 * @param end the upper bound of the range of sub programs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sub programs
	 */
	public java.util.List<SubProgram> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SubProgram>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the sub programs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of sub programs.
	 *
	 * @return the number of sub programs
	 */
	public int countAll();

}