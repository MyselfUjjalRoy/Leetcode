class Solution(object):
    def countCommas(self, n):
        """
        :type n: int
        :rtype: int
        """
        comma = n - 999
        return comma if comma > 0  else 0
        