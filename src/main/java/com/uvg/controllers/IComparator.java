package com.uvg.controllers;

    /**
     * The IComparator interface provides a method for comparing two objects of type T.
     * @author Angel Sanabria
     * @author Pablo Vasquez
     * @param <T> The type of objects that this comparator can compare.
     */
    public interface IComparator<T> {
        /**
         * Compares two objects of type T.
         *
         * @param _object1 The first object to be compared.
         * @param _object2 The second object to be compared.
         * @return A negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
         */
        public int Compare(T _object1, T _object2);
    }